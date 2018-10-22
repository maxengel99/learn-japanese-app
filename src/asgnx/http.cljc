(ns asgnx.http
  (:require [clojure.data.json :as json]
            #?(:clj [dotenv :refer [env app-env]])
            #?(:cljs [cljs-http.client :as clj-client]
               :clj  [clj-http.client :as clj-client])))

;; holds api key for Yandex translation api
(def api-key (env "YANDEX_API_KEY"))

;; contains mappings of language to language code
(def lang-map (hash-map :spanish "es"
                        :italian "it"
                        :french "fr"
                        :german "de"
                        :swedish "sv"
                        :portugese "pt"))

;; creates the string for the given language and text
(defn make-url [text]
  (str "https://translate.yandex.net/api/v1.5/tr.json/translate?key="
       (str api-key)
       "&lang=en-"
       (get lang-map (keyword (second (get text :args))))
       "&text="
       (first (get text :args))))

;; makes the get-request
(defn get-request [text]
  #? (:clj (get (clj-client/get (make-url text)) :body)
       :cljs (get (cljs-client/get url) :body)))

;; gets the translated word from the response
(defn parse-response [response]
  (json/read-str response :key-fn keyword))

;; handles the request from core
(defn request [text]
  (if (contains? lang-map (keyword (second (get text :args))))
    (first (get (parse-response (get-request text)) :text))
    (str "Language not supported")))

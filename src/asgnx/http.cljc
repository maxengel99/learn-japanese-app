(ns asgnx.http
  (:require [clojure.data.json :as json]
            #?(:clj [dotenv :refer [env app-env]])
            #?(:cljs [cljs-http.client :as clj-client]
               :clj  [clj-http.client :as clj-client])))

;; Holds api key for Yandex translation api
(def api-key (env "YANDEX_API_KEY"))

;; Contains mappings of language to language code
(def lang-map (hash-map :spanish "es"
                        :italian "it"
                        :french "fr"
                        :german "de"
                        :swedish "sv"
                        :portugese "pt"))

;; Turns language into key for map lookup
(defn create-key-lang [text]
  (keyword (second (get text :args))))


;; Creates the string for the given language and text
(defn make-url [text]
  (str "https://translate.yandex.net/api/v1.5/tr.json/translate?key="
       (str api-key)
       "&lang=en-"
       (get lang-map (create-key-lang text))
       "&text="
       (first (get text :args))))

;; Makes the get-request
(defn get-request [text]
  #? (:clj (get (clj-client/get (make-url text)) :body)
       :cljs (get (cljs-client/get url) :body)))

;; Gets the translated word from the response
(defn parse-response [response]
  (json/read-str response :key-fn keyword))

;; Handles the request from core
(defn request [text]
  (if (contains? lang-map (create-key-lang text))
    (first (get (parse-response (get-request text)) :text))
    (str (str (second (get text :args))) " is not supported")))

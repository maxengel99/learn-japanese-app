(ns asgnx.http
  (:require [clojure.string :as string]
            [clojure.core.async :as async :refer [go chan <! >!]]
            [asgnx.kvstore :as kvstore
             :refer [put! get! list! remove!]]
            [clojure.data.json :as json]
            #?(:clj [dotenv :refer [env app-env]])
            #?(:cljs [cljs-http.client :as clj-client]
               :clj  [clj-http.client :as clj-client])))

(def lang-map (hash-map :spanish "es"))

(def api-key (env "YANDEX_API_KEY"))

(defn make-url [text]
  (str "https://translate.yandex.net/api/v1.5/tr.json/translate?key="
               (str api-key)"&lang=en-"
                               (get lang-map (keyword (second (get text :args))))
                               "&text="
                               (first (get text :args))))

(defn actually-make-request [text]
  #? (:clj (get (clj-client/get (make-url text)) :body)
       :cljs (get (cljs-client/get url) :body)))

(defn parse-response [response]
  (json/read-str response :key-fn keyword))

(defn request [text]
  (if (contains? lang-map (keyword (second (get text :args))))
    (first (get (parse-response (actually-make-request text)) :text))
    (str "Language not supported")))

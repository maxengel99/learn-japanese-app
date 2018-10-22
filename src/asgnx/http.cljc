(ns asgnx.http
  (:require [clojure.string :as string]
            [clojure.core.async :as async :refer [go chan <! >!]]
            [asgnx.kvstore :as kvstore
             :refer [put! get! list! remove!]]
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


(defn request [text]
 ;(let [url (str "https://translate.yandex.net/api/v1.5/tr.json/translate?key="
  ;              (str api-key)"&lang=en-"
  ;                              (second (get text :args))
  ;                              "&text="
  ;                              (first (get text :args))]
   #? (:clj (get (clj-client/get (make-url text)) :body)
       :cljs (get (cljs-client/get url) :body)))
; #? (:clj (get (clj-client/get (str "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20181011T162540Z.ebefbd687bfa078b.2860aebc9fea214e51dce9f033f51fec0a552afb&lang=en-"
;                                (second (get text :args))
;                                "&text="
;                                (first (get text :args)))) :body
;          :cljs (cljs-client/get (str "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20181011T162540Z.ebefbd687bfa078b.2860aebc9fea214e51dce9f033f51fec0a552afb&lang=en-"
;                                         (second (get text :args))
;                                         "&text="
;                                         (first (get text :args))))))
          ;:cljs (go (get (<! (cljs-client/get
          ;                              (str "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20181011T162540Z.ebefbd687bfa078b.2860aebc9fea214e51dce9f033f51fec0a552afb&lang=en-"
          ;                                   (second (get text :args))
          ;                                   (second (get text :args))
          ;                                   "&text="
          ;                                   (first (get text :args))
          ;                              {:with-credentials? false})) :body)

        ;  :cljs (get (cljs-client/get (str "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20181011T162540Z.ebefbd687bfa078b.2860aebc9fea214e51dce9f033f51fec0a552afb&lang=en-"
        ;                                 (second (get text :args))
        ;                                 "&text="
        ;                                 (first (get text :args)))) :body)
;;#? (:clj (str "test") :cljs (str "cljs")))
  ;(get (clj-client/get (str "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20181011T162540Z.ebefbd687bfa078b.2860aebc9fea214e51dce9f033f51fec0a552afb&lang=en-"
  ;                           (second (get text :args))
  ;                          "&text="
  ;                          (first (get text :args))]
  ;     :body)

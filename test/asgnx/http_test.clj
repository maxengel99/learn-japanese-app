(ns asgnx.core-test
  (:require [clojure.test :refer :all]
            [clojure.core.async :refer [<!!]]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]
            [clojure.test.check.generators :as gen]
            [asgnx.core :refer :all]
            [asgnx.http :refer :all]
            [dotenv :refer [env app-env]]
            [asgnx.kvstore :as kvstore :refer [put! get!]]))

(deftest create-key-lang-test
  (testing "Creates a key from the language given text input"
    (is (= :spanish (create-key-lang ["dog" "spanish"])))
    (is (= :german (create-key-lang ["food" "german"])))))


(deftest make-url-test
  (testing "Creates the url string with the correct queries"
    (is (= (str "https://translate.yandex.net/api/v1.5/tr.json/translate?key="
            (str (env "YANDEX_API_KEY"))
            "&lang=en-es&text=dog")
            (make-url ["dog" "spanish"])))))

(deftest parse-response-test
  (testing "Properly gets the text translation from api response"
    (is (= "perro" (parse-response [{"code":200,"lang":"en-es","text":["perro"]}])))))

(deftest request-test
  (testing "Properly calls correct functon given a language"
    (is (= "hebrew is not supported")(request ["apple" "hebrew"]))))

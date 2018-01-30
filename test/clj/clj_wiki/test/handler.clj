(ns clj-wiki.test.handler
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer :all]
            [clj-wiki.handler :refer :all]
            [mount.core :as mount]))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'clj-wiki.config/env
                 #'clj-wiki.handler/app)
    (f)))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= 404 (:status response))))))

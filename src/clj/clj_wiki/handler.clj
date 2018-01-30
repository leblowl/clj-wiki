(ns clj-wiki.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [clj-wiki.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [clj-wiki.env :refer [defaults]]
            [mount.core :as mount]
            [clj-wiki.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
          #'service-routes
      (route/not-found
        "page not found"))))

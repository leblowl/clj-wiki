(ns clj-wiki.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [clj-wiki.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[clj-wiki started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[clj-wiki has shut down successfully]=-"))
   :middleware wrap-dev})

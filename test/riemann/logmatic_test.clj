(ns riemann.logmatic-test
  (:use riemann.logmatic
        [riemann.time :only [unix-time]]
        clojure.test)
  (:require [riemann.logging :as logging]))

(logging/init)

(deftest ^:logmatic ^:integration logmatic-test
         (let [k (logmatic {:api-key "logmatic-key"})]
           (k {:host "riemann.local"
               :service "logmatic test"
               :state "ok"
               :description "all clear, uh, situation normal"
               :metric -2
               :time (unix-time)})))

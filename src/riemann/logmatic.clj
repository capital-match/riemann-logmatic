(ns riemann.logmatic
  "Forwards events to logmatic

See [Logmatic.io](http://doc.logmatic.io/) documentation for details on API"
  (:require [clj-http.client :as client]
            [riemann.common :refer [body event-to-json]]))

(def ^:private messages-url
  "https://api.logmatic.io/v1/input/%s")

(defn- post
  "POST to the logmatic API.

* `msg`: a JSON message to send to the logmatic API
* `logmatic-opts`: Options to post to logmatic.io. Contains essentially the `api-key`
* `msg-opts`:"
  [msg logmatic-opts]
  (client/post (format messages-url (:api-key logmatic-opts))
               {:content-type :json
                :body msg
                :socket-timeout 5000
                :conn-timeout 5000
                :accept :json
                :throw-entire-message? true}))



(defn logmatic
  "Return a function which accepts event and sends it to logmatic.
  Usage:

  (logmatic {:api-key \"bn14a6ac2e3b5h795085217d49cde7eb\"})

  Option:

  :api-key    Logmatic's API Key for authentication."
  ([opts]
   (let [opts (merge {:api-key "logmatic-api-key"} opts)]
     (fn [event]
       (let [json-data (event-to-json event)]
         (post json-data opts))))))
  

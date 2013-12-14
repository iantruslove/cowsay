(ns cowsay.core
  (:require [cowsay.animal :refer [body]]
            [cowsay.text-formatter :refer [bubble]]
            [clojure.string :refer [join]])
  (:gen-class :main true))

(defn cowsay [text]
  (str (bubble 39 text) "\n"
       (body :cow)))

(defn -main
  "The application's main function"
  [& args]
  (println args))

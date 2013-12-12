(ns cowsay.text-formatter
  (:require [clojure.string :refer [join]]))

(def line-length "Maximum single-line length of a cowsay" 39)

(defn cowformat [s]
  "Line wraps the string s appropriately for cowsaying.
  TODO:  give a crap about splitting on word boundaries."
  (loop [lines []
         remainder s]
    (if (not (seq remainder))
      lines
      (recur (conj lines (apply str (take line-length remainder)))
             (drop line-length remainder)))))

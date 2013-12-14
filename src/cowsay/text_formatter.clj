(ns cowsay.text-formatter
  (:require [clojure.string :refer [join split-lines trim]]))

(def default-line-length "Maximum single-line length of a cowsay" 39)

(defn fill-line [c n]
  (str " " (apply str (repeat (+ 2 n) c))))

(def first-line "Text length is l"
  (partial fill-line "_"))

(def last-line "Text length is l"
  (partial fill-line "-"))

(defn add-bookends [line]
  (str "< " line " >"))

(defn pad-to [n line]
  (str line (apply str (repeat (- n (count line)) " "))))

(defn bookend-and-pad [n line]
  (->> line (pad-to n)
       (add-bookends)))

(defn max-line-length [lines]
  (apply max (map count lines)))

(defn enclose
  [lines]
  (let [text-length (max-line-length lines)
        bookend-and-pad (partial bookend-and-pad text-length)]
    (join "\n" [(first-line text-length)
                (join "\n" (map bookend-and-pad lines))
                (last-line text-length)])))

(defn wrap [s line-length]
  "Line wraps the string s appropriately for cowsaying.
  TODO:  give a crap about splitting on word boundaries."
  (loop [lines []
         remainder s]
    (if (not (seq remainder))
      lines
      (recur (conj lines (apply str (take line-length remainder)))
             (drop line-length remainder)))))

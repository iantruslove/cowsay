(ns cowsay.text-formatter-test
  (:require [cowsay.text-formatter :refer :all]
            [clojure.test :refer :all]))

(deftest test-formatter
  (testing "Short phrases aren't wrapped"
    (is (= ["no line wraps"] (cowformat "no line wraps" default-line-length))))

  (testing "39-letter words fit in whole"
    (let [long-word (apply str (repeat 39 "a"))]
      (is (= [long-word] (cowformat long-word default-line-length)))))

  (testing "40+ letter words are split onto new lines"
    (let [long-word (apply str (repeat 39 "a"))]
      (is (= [long-word long-word]
             (cowformat (str long-word long-word) default-line-length))))))

(ns cowsay.text-formatter-test
  (:require [cowsay.text-formatter :refer :all]
            [clojure.test :refer :all]))

(deftest test-enclose
  (testing "single words are wrapped"
    (is (= " _____\n< moo >\n -----" (enclose ["moo"]))))
  (testing "multiple lines are wrapped"
    (let [expected-text " __________\n< moo      >\n< says cow >\n ----------"]
      (is (= expected-text (enclose ["moo" "says cow"]))))))

(deftest test-wrap
  (testing "Short phrases aren't wrapped"
    (is (= ["no line wraps"] (wrap "no line wraps" default-line-length))))

  (testing "39-letter words fit in whole"
    (let [long-word (apply str (repeat 39 "a"))]
      (is (= [long-word] (wrap long-word default-line-length)))))

  (testing "40+ letter words are split onto new lines"
    (let [long-word (apply str (repeat 39 "a"))]
      (is (= [long-word long-word]
             (wrap (str long-word long-word) default-line-length))))))

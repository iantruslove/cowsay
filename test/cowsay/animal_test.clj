(ns cowsay.animal-test
  (:require [cowsay.animal :refer :all]
            [clojure.test :refer :all]))

(deftest test-body
  (let [cow-body "nice fake cow"
        default-body "nasty default body"]

    (with-redefs [cowsay.animal/morphology
                  (merge morphology {:cow {:body cow-body}
                                     :default {:body default-body}})]
      (testing "known body types return something nice"
        (is (= cow-body (body :cow))))
      (testing "invalid body types return something nasty"
        (is (= default-body (body :foo)))))))

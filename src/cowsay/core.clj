(ns cowsay.core
  (:gen-class :main true))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn -main
  "The application's main function"
  [& args]
  (println args))



(ns cowsay.animal)

(def cow-body 
"        \\   ^__^
         \\  (oo)\\_______
            (__)\\       )\\/\\
                ||----w |
                ||     ||")

(def pig-body
"        \\        ,.
         \\      (_|,.
          \\    ,' /, )_______   _
            __j o``-'        `.'-)'
           (\")                 \\'
            `-j                |
              `-._(           /
                 |_\\  |--^.  /
                /_]'|_| /_)_/
                   /_]'  /_]'")



(def snake-body
 "                             ____
    ________________________/ O  \\___/
   <%%%%%%%%%%%%%%%%%%%%%%%%_____/   \\")

(def morphology {:cow {:body cow-body}
                 :pig {:body pig-body}
                 :default {:body snake-body}})

(defn body
  "Return a string for the given animal keyword"
  [animal]
  (or (-> morphology animal :body)
      (-> morphology :default :body)))


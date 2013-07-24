(require '[clojure.string :refer [join]])

(def r* #(->> "*" (repeat %) join))

(defn obfuscated-password1 [pass]
  (let [len (count pass)]
    (if (< len 3)
      (r* len)
      (str (first pass) (r* (- len 2)) (last pass)))))

(defn obfuscated-password2 [pass]
  (let [r (re-seq #"(.)(.+)(.)" pass)]
    (if r
      (let [[p x n] (rest (first r))]
        (str p (r* (count x)) n))
      (r* (count pass)))))

;; test
(doseq [f [obfuscated-password1 obfuscated-password2]]
  (assert (= "" (f "")))
  (assert (= "*" (f "s")))
  (assert (= "**" (f "ss")))
  (assert (= "s*s" (f "sss")))
  (assert (= "s**s" (f "saas"))))

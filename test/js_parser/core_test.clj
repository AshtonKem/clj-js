(ns js-parser.core-test
  (:require [clojure.test :refer :all]
            [js-parser.core :refer :all]))



(deftest primary-expression-test
  (doseq [var ["true" "false" "null" "-45" "this" "45.76" "'hello'" "\"hello\""]]
    (is (= (parse-js var) [:Program [:PrimaryExpression var]]))
    )
  (is (= (parse-js "fooBar") [:Program [:Identifier [:VariableName "fooBar"]]]))
  (is (= (parse-js "_") [:Program [:Identifier [:VariableName "_"]]]))
  (is (= (parse-js "ooBar") [:Program [:Identifier [:ClassName "FooBar"]]]))
  )

(run-all-tests)

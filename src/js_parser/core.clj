(ns js-parser.core
   (:require [instaparse.core :as insta]))

(def parse-js
  (insta/parser
    "
Program = (PrimaryExpression | Identifier)+
PrimaryExpression = \"true\" |
                    \"false\" |
                    \"this\" |
                    \"null\" |
                    #'-?[0-9]+' |
                    #'-?[0-9]+\\.[0-9]+' |
                    #'\\'.*\\'' |
                    #'\".*\"';
VariableName = #'((?!this)(?!null)(?!true)(?!false)(_|[a-z])[a-zA-Z]*)';
ClassName = #'((?!this)(?!null)(?!true)(?!false)[A-Z][a-zA-Z]+)';
Identifier = VariableName | ClassName
"))

(parse-js "_")

;PrimaryExpression:
;          ( Expression )
;          Identifier
;          IntegerLiteral
;          FloatingPointLiteral
;          StringLiteral
;          false
;          true
;          null
;          this

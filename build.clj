(ns build
  (:require [clojure.tools.build.api :as b]))

(defn aot [_]
  (b/delete {:path "target"})
  (b/compile-clj {:basis (b/create-basis {})
                  :class-dir "target/classes"
                  :uber-file "target/example.jar"
                  :ns-compile ['clojure.core.async
                               'clojure.tools.analyzer.jvm.utils]}))

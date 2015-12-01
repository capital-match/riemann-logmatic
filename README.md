# riemann-logmatic

A simple [riemann](http://riemann.io) plugin to send events to [Logmatic](http://logmatic.io). 

## Installing

You will need to build this module for now and push it on riemann's classpath, for this you will need a working JDK, JRE and leiningen.

First build the project:

    lein uberjar

The resulting artifact will be in `target/riemann-logmatic-standalone-0.1.0.jar`. You will need to push that jar on the machine(s) where riemann runs, for instance, in `/usr/lib/riemann/riemann-logmatic.jar`.

If you have installed riemann from a stock package you will only need to tweak `/etc/default/riemann` and change the line `EXTRA_CLASSPATH` to read:

    EXTRA_CLASSPATH=/usr/lib/riemann/riemann-logmatic.jar

You can then use exposed functions, provided you have loaded the plugin in your configuration.


## Usage

In `riemann.config`

     (load-plugins)

     (let [lm (logmatic/logmatic {:api-key "1234567890"})]
       (streams
         lm))


## License

Copyright © 2015 Arnaud Bailly

Distributed under the Eclipse Public License either version 2.0.

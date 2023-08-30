# sbt-assembly-log4j2

**Problem**: When including several projects that include `log4j2` plugins,
`sbt-assembly` will encounter multiple versions of the `Log4j2Plugins.dat`
cache file that it won't be able to reconcile.

**Solution**: Log4j2 provides a `PluginCache` class that creates consistent,
serialisable cache from multiple different ones.

**This plugin** provides a simple function to merge those files in a safe way.

## Usage

For sbt 1.3+ add `sbt-assembly-log4j2` as a dependency in
`project/assembly.sbt` alongside [`sbt-assembly`][sbt-assembly]:


`project/plugins.sbt`:
```scala
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.1.1")
addSbtPlugin("com.michaelpollmeier" % "sbt-assembly-log4j2" % "1.1.3")
```

`build.sbt`
```scala
assembly/assemblyMergeStrategy := {
  case "META-INF/org/apache/logging/log4j/core/config/plugins/Log4j2Plugins.dat" =>
    sbtassembly.Log4j2MergeStrategy.plugincache
}
```

Latest version of [sbt-assembly](https://github.com/sbt/sbt-assembly#setup)
Requires sbt 1.3+

## Credits
* [Stathis Charitos](https://github.com/stathischaritos) for the idea and [creating the first version](https://github.com/idio/sbt-assembly-log4j2). Unfortunately it's unmaintained and only available for a outdated sbt and sbt-assembly versions.
* [Ben Reyes](https://github.com/fnqista) for providing an [upgrade PR](https://github.com/idio/sbt-assembly-log4j2/pull/15) that got incorporated here. 

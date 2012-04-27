import groovy.io.*

includeTargets << grailsScript("_GrailsInit")

target(main: "Searches for notes witin codes!") {
def todoMark = /(\/\/TODO):/
def dir = new File('./grails-app')
dir.traverse(
   type:FileType.FILES,
   nameFilter:~/.*\.groovy/
){_file->
   _file.eachLine{line-> 
      if(line.contains("//TODO:")){
         def note = line.split(":")[1].trim()
         if(!note.isAllWhitespace())
            println "File: ${_file}:"
            println line.split(":")[1].trim()
      }
   }
}

println "Done."
}

setDefaultTarget(main)

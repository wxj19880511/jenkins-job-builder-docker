folder('TEST_FOLDER') {
    
    description('Folder containing all QA jobs for project A')

    views {
        listView("TEST_VIEW") {
            description('All unstable jobs for project A')
            filterBuildQueue()
            filterExecutors()

            jobs {
                name('5G18A-QT')
                regex(/5G18A-.+-QT/)
            }

            columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
                lastDuration()
                buildButton()
            }
        }
    }
}

job('TEST_FOLDER/5G18A-4.8-QT') {
    logRotator(-1, 10)
    jdk('Java 6')
}

folder('TEST_FOLDER/f1') {
    
    description('Folder containing all QA jobs for project A')
}

folder('TEST_FOLDER/f1/f2') {
    
    description('Folder containing all QA jobs for project A')
}
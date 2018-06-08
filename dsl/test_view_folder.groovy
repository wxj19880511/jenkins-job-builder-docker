folder('TEST_FOLDER') {
    
    description('Folder containing all QA jobs for project A')

    views {
        listView("TEST_VIEW") {
            description('All unstable jobs for project A')
            filterBuildQueue()
            filterExecutors()

            jobs {
                name('5G18A-QT')
                regex(/build-axe1.+/)
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

folder('TEST_FOLDER/f1') {
    
    description('Folder containing all QA jobs for project A')
}

folder('TEST_FOLDER/f1/f2') {
    
    description('Folder containing all QA jobs for project A')
}
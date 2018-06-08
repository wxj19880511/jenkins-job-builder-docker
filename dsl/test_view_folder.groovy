folder('TEST_FOLDER') {
    
    description('Folder containing all QA jobs for project A')

    views {
        listView("TEST_VIEW") {
            description('All unstable jobs for project A')
            filterBuildQueue()
            filterExecutors()
        }
    }
}

folder('TEST_FOLDER/f1') {
    
    description('Folder containing all QA jobs for project A')
}

folder('TEST_FOLDER/f1/f2') {
    
    description('Folder containing all QA jobs for project A')
}
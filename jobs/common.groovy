println(message)

folder('DSL/fa') {
    description('Folder containing all jobs for folder-a')
}

job('DSL/fa/acme-tests') {
    description("just a test")
}
println(message)

job('acme-tests') {
    description(readFileFromWorkspace('acme-tests', 'README.txt'))
}
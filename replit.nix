{ pkgs }: {
    deps = [
        pkgs.openjdk
        pkgs.maven
        pkgs.replitPackages.jdt-language-server
        pkgs.replitPackages.java-debug
    ];
}
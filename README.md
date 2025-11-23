
# CardinalLib

CardinalLib is a library created by QHSS Cardinals 19426's programming team. This is a living repository that houses reusable code we found easier to abstract. This library is inspired by Stuy Fission's FissionLib.

## Installation

In your FTC Robot Controller project, add CardinalLib as a dependency in your `build.gradle.kts` file:

```kotlin
dependencies {
    implementation("com.github.qhss-cardinal-robotics:CardinalLib:<commit-hash-or-tag>")
}
    repositories {
    mavenCentral()
    maven { url "https://jitpack.io" }
}
```

Replace `<commit-hash-or-tag>` with the version or commit you want to use from JitPack.
## Deployment

To deploy the library via [JitPack](https://jitpack.io/):
1. Make sure your code is merged into the main branch.
1. Go to [JitPack CardinalLib page](https://jitpack.io/#danvluewubley/CardinalLib) and select the desired commit or tag to get the dependency URL.

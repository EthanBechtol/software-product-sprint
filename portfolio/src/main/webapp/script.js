// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
    const greetings =
        ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

    // Pick a random greeting.
    const greeting = greetings[Math.floor(Math.random() * greetings.length)];

    // Add it to the page.
    const greetingContainer = document.getElementById('greeting-container');
    greetingContainer.innerText = greeting;
}


/**
 * Cycles the subtitle under my name every 10 seconds and adds a fade-in/out effect when doing so.
 */
function cycleSubtitle() {
    const subtitles =
        ['Aspiring software engineer', 'UCI Lab Tutor', 'Anteater', 'Computer Science student at UCI',
            'Computer Science student at UCI', 'Mountain biker'];

    // Pick a random subtitle.
    const newSub = subtitles[Math.floor(Math.random() * subtitles.length)];

    // Fade the old subtitle out, change it, and fade it back in.
    const subtitleContainer = document.getElementById('subtitle');
    subtitleContainer.style.opacity = '0';
    window.setTimeout(() => {
        subtitleContainer.innerHTML = "<h3>" + newSub + "</h3>";
        subtitleContainer.style.opacity = '1';
    }, 1000)
}

window.setInterval(cycleSubtitle, 10_000);
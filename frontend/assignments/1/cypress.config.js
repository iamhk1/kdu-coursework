const { defineConfig } = require("cypress");
const getCompareSnapshotsPlugin = require("cypress-visual-regression/dist/plugin");

// Export Cypress configuration using defineConfig function
module.exports = defineConfig({
  // Trash assets (screenshots, videos) before each test run
  // screenshotsFolder : "cypress/screenshots",
  trashAssetsBeforeRuns: true,

  // Disable video recording during test runs
  video: false,

  // Configuration for end-to-end (e2e) tests
  e2e: {
    // Base URL for your application
    baseUrl: "https://harshfrontendassignment1-bze6g6f6hudjc4ce.z02.azurefd.net/harshfrontendcontainer",

    // Setup Node events for visual regression testing using cypress-visual-regression plugin
    setupNodeEvents(on, config) {
      // Integrate the compareSnapshots plugin into Cypress
      getCompareSnapshotsPlugin(on, config);
    },
  },
  // Environment variables
  env: {
    EMAIL: "test@gmail.com",
    PASSWORD: "test",
    USERNAME: "test-user",
    NAME: "test-name",
    HOME_PAGE_URL: "/index.html",
    LOGIN_PAGE_URL: "",
    REGISTER_PAGE_URL: "",
    TEST_THRESHOLD: 0.35,
  },
});

<template>
  <div class="report">
    <WaitingModal v-if="fetchingReport" />
    <Report v-if="report" :report="report" />
    <NotFound v-if="notFound" />
  </div>
</template>

<script>
import Report from "@/components/Report.vue";
import NotFound from "@/components/NotFound.vue";
import WaitingModal from "@/components/WaitingModal.vue";

import axios from "axios";

export default {
  components: { Report, WaitingModal, NotFound },
  data() {
    return {
      fetchingReport: true,
      notFound: false,
      report: null,
    };
  },
  mounted() {
    const that = this;
    axios
      .get("http://localhost:8082/v1/credit-report/" + this.$route.params.id)
      .then((response) => {
        if (!response.data.success) {
          that.notFound = true;
        } else {
          that.report = JSON.parse(response.data.data);
        }
        that.fetchingReport = false;
      })
      .catch((err) => {
        that.fetchingReport = false;
        that.notFound = true;
        console.log(err);
      });
  },
};
</script>

<style scoped></style>

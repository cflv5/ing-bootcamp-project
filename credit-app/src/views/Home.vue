<template>
  <div class="home">
    <CreditReportRequestFrom
      :hidden="showResult"
      ref="creditReportForm"
      :onSubmit="onSubmit"
    />
    <WaitingModal v-if="isSubmitting" />
    <RequestResult
      :background="resultClass"
      @reset="resetForm"
      v-if="showResult && responeMessage"
      >{{ responeMessage }}</RequestResult
    >
  </div>
</template>

<script>
import CreditReportRequestFrom from "@/components/CreditReportRequestFrom.vue";
import WaitingModal from "@/components/WaitingModal.vue";
import RequestResult from "@/components/RequestResult.vue";

import axios from "axios";

export default {
  data() {
    return {
      isSubmitting: false,
      showResult: false,
      responeMessage: "",
      resultClass: "",
    };
  },
  components: { CreditReportRequestFrom, WaitingModal, RequestResult },
  methods: {
    onSubmit(form) {
      const that = this;
      this.isSubmitting = true;
      axios
        .post("http://localhost:8082/v1/credit-report", form)
        .then((response) => {
          if (!response.data.success) {
            that.resultClass = "danger";
          }
          that.showResult = true;
          that.isSubmitting = false;
          that.responeMessage = response.data.data;
        })
        .catch((err) => {
          that.resultClass = "danger";
          that.showResult = true;
          that.isSubmitting = false;
          that.responeMessage =
            "Teknik bir sorun oluştu. Lütfen daha sonra tekrar deneyin.";
          console.log(err);
        });
    },
    resetForm() {
      this.$refs.creditReportForm.reset();
      this.isSubmitting = false;
      this.showResult = false;
      this.responeMessage = "";
      this.resultClass = "";
    },
  },
};
</script>

<style scoped>
.home {
  padding: 5rem;
}
</style>
>

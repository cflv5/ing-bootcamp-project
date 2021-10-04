<template>
  <div class="report">
    <div class="report_details">
      <div class="report_detail">
        <div class="report_detail__inline">
          <label for="ssn">Kimlik No: </label>
          <div class="report_text">{{ report.customer.ssn }}</div>
        </div>
        <div class="report_detail__inline">
          <label for="name">Ad: </label>
          <div class="report_text">{{ report.customer.name }}</div>
        </div>
        <div class="report_detail__inline">
          <label for="ssn">Soyad: </label>
          <div class="report_text">{{ report.customer.surname }}</div>
        </div>
      </div>
      <div class="report_detail">
        <div class="report_detail__inline">
          <label for="name">Alabileceğiniz Kredi Miktarı: </label>
          <div class="report_text">{{ report.amount }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    report: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>
label {
    font-size: 1.2rem;
}

.report {
    width: 100%;
    display: flex;
    flex-direction: column;
    margin-top: 5rem;
}

.report_detail__inline {
    display: inline;
    margin: 1.4rem 1.2rem;
    align-self: flex-end;
}

.report_details {
    background: white;
    width: 50%;
    align-self: center;
}

.report_detail {
    margin: 1.2rem;
    display: block;
}

.report_text {
    display: inline;
    padding: 1.2rem 0;
    border: 0.2rem;
}
</style>

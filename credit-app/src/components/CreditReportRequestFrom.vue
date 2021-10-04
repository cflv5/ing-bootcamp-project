<template>
  <div>
    <div class="title">Kredi Rapor Formu</div>
    <div class="callout danger" v-if="!validForm">
      Lütfen bütün alanları doldurun.
    </div>
    <form @submit="performSubmit">
      <div class="form-group">
        <label for="ssn">Kimlik no</label>
        <input type="text" v-model="form.ssn" required />
      </div>
      <div class="form-group">
        <label for="name">Ad</label>
        <input type="text" v-model="form.name" required />
      </div>
      <div class="form-group">
        <label for="surname">Soyad</label>
        <input type="text" v-model="form.surname" required />
      </div>
      <div class="form-group">
        <label for="birthday">Doğum Tarihi</label>
        <input type="date" v-model="form.birthday" required />
      </div>
      <div class="form-group">
        <label for="email">E-Posta</label>
        <input type="email" v-model="form.email" required />
      </div>
      <div class="form-group">
        <label for="phone">Telefon Numarası</label>
        <input type="text" v-model="form.phone" required />
      </div>

      <button class="submit">Gönder</button>
    </form>
    <div class="small">Lütfen alanları doldurunuz.</div>
  </div>
</template>

<script>
function validateForm(form) {
  if (
    !form.ssn ||
    !form.name ||
    !form.surname ||
    !form.email ||
    !form.phone ||
    !form.birthday
  ) {
    return false;
  }
  return true;
}
export default {
  props: {
    onSubmit: {
      type: Function,
      required: true,
    },
  },
  data() {
    return {
      validForm: true,
      form: {
        ssn: "",
        name: "",
        surname: "",
        email: "",
        phone: "",
        birthday: "",
      },
    };
  },

  methods: {
    performSubmit(event) {
      event.preventDefault();
      this.validForm = validateForm(this.form);

      if (this.validForm) {
        this.onSubmit(this.form);
      }
    },
    reset() {
      this.form.ssn = "";
      this.form.name = "";
      this.form.surname = "";
      this.form.email = "";
      this.form.phone = "";
      this.form.birthday = "";
    }
  },
};
</script>

<style scoped>
.title {
    font-size: 2.2rem;
    margin: 0.6rem;
    color: #129;
}

.callout {
    display: block;
    margin: 1rem;
    padding: 1rem;
    border-radius: 0.3rem;
}

.danger{
    background: red;
    color: white;;
}

form {
    background: #fff;
    display: flex;
    flex-direction: column;
    border-radius: 0.3rem;
}

.form-group {
    padding: 1.2rem;
    text-align: left;
    margin: auto;
    width: 100%;

}

.form-group input {
    display: block;
    width: 94%;
    padding: 0.5rem 0.3rem;
    /* margin: 0.7rem 0.7rem; */
    font-size: 1.1rem;
}

.form-group label {
    color: #111;
    font-size: 1.2rem;
    display: inline;
    margin: 0.7rem 0.7rem;
}

.submit {
    margin: 0 0 1rem 0;
    align-self: center;
    background-color: #4CAF50; /* Green */
    border: none;
    border-radius: 0.5rem;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
.small {
    margin: 0.5rem;
    text-align: left;
}
</style>

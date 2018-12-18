export const getUserId = () => {
  let id = document.cookie.match('loveinDC_token');
  console.log(document.cookie);
  return id;
}
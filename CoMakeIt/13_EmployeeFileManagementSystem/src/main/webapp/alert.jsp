<!-- This page is displayed when the user did not complete 100 days and still tries to update address
as the update rights will only be given to those users who have completed their 100 days -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Property.css" />
<script>
	function validLogin() {
		alert("Sorry!!You are not Eligible");
	}
</script>
</head>

<body onLoad="validLogin();">
	<form action="user.jsp">
		<img
			src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARUAAAC2CAMAAADAz+kkAAAA81BMVEX////JJzz///5DQ0PIGzTTeoTEHjXUdX/JJzvJJz7HKDzKJzrKX2vGf4nBGzLdl6DMb3r14ea9Kj3ptbs4ODg1NTU+Pj7/+fz86e6+NEXZqbGvEiv1xMr/8PK8Ijf22t64Fi7r0dTn5+dMTEzvys+SkpK9TlvKysp+fn7e3t4tLS3gub68ECrSjJPhoqm/VWK5ubm4O0pxcXHXjJbFZG7z8/OlpaWDg4NZWVmyKTrAaHTEQlDktbr10de+DibThZG0N0jQ0NChoaEgICDGTVrFhYvCeIPNmp+pABzGECy7YG27aW7LPE7LSVnLVGPRlZzfhZAjn79BAAAQ20lEQVR4nO1di1/iuBZOM6GbNlh5KKVqS1XGmdGKy4gz6wPdhzuzzj68//9fc3NOUihQEHbH0gLfb9e9t7Ql/Tg5OTmvErLBBhtssMEGG2ywwQYbbLDBBnmB26y2qk132cPIC6j81z/7chsBbr+c+frY2uOu6zBuGPAPc7p3eGzdian2IiH5AE6E/COiXpOsNSuUUtLyTM65LVmxJTVADrtuwUfLHtzygKTA3LEsQwqKpWXGay17YMuFe8IsZEPBwn8MdrLei9FlZCk9C5Tg/OGG1DLO5bIHtgworUFJdR8I4bbNQUSEFBTLFnBkv6r07bqpF3zcigk6BZlhTuAwEBlJkLDMG3nCmjECACloh0IKitS0tlE7b7fa5zXOQVzkGh2213F1BlLcCwaalsuFp9bHo/0aahZ5DBUuXUd52YtANGAxjupEWS/1eyk8qHijPbKO0kL8mpBTBzSJeRGvxO6FiQuSbYiav46SQh4cMPLBpAUlAoIhhQVUjQEWneE8rJ+syFU5kIxwUCusNHh8SkrMlnMIFqKguoas9Jg0U+TT23y/CY9P1Z/mvrBR13DWW/YgswYlB6GwlaXibOtDyArZdsCEkZtFER4seZSZw32U0mDBRBFdf2jCyv/6XTBi5KeG+bhu26FOhFas/BPekRFWyF0I+yFYn6POMoeYPZo1ufkxpGIxzPLEUlOWqzN8avBacznDWxK2TLUL5FbYiiVF/6WkFaJTQZ7AtpY5yOygNGo/MEAW5AxySilWSck08HPbCPprsW9WT1g2beVm4jU/hRX/WiiXi5pfq2/j4hOeRbYSBmOKPu1EXH1uR2fqqtWH29WSYIgTP/2ME6F2Q4bw1sPRQsl2pHaFuAGa1Bpw5CBUtNm287yMQWYNuQGqaXvEBps+RQ7gUM/ESQaap5r5GLMGzIaSo/zX3Ahb+uDoKQC5Oqtpxp3Sys8h9BXA1g+cCM6DdlmPnqL+XDocXJXScEmdZquGC0NNIC68dFWr4HtInjx16JNaXdxF4IOUu2XuzN7ldBwMDVmCo/9ypeH/LCxhW1Je5I44MS+uPn3+/OPIme4jOCttebb4eZZQrQKemVaiRtROKJR3u7uNxu7xVfLUNm6rMX9jZVdnxQCuyhYEgVglQcpR4w1g5+PIBRXTwoAiF3p1Xk2dKx+UoSUvBSBIpmO83UFW3uweDU6VH7UCpW65MULhKgEZgEmhk5qek895/EazklQtdDDdDJhuq7l5hmd6NCBTRepQcEsOcXWqWdl5O3KJ3xV6b208riYp8NvvRTY4VWyuFtvBU36IWWm8T55OSD3iXPHi7K3oHCJNT8BWGNySJ/D/Bz/+u92YlaG6VZ+dmOCrBEPYW1Vn5aVjKFIMnXEQs/JjOiuYtWBoWlY10acVaCVhmSUywsoUWYGPS6bNld8hWLFkORo7B3D1kf+i+ZFQE0NW3o9dJw0clXAqZ12PjFC5GjiIlDPWtqLtsY+G2vbzxGXbjnIpcLU6rxAwhedEcG3se+7Y7300WJk/TVzqegJTLC1b6ESfVQE8CjioLcw2ju7GP7+KZ9Duj5MX30WooiUr6PpeHVYIBAsF5jXZBitPfjqwbX9JubRsQpoLbodWaHXGbJ0HXJUhYT84nDzlY0Oz8iHl+sOAC1vA+gzOu1XxVsJTtELlWLMwhWfiud5rVnZSb/CFCZXJzqMWWaU5JGcBGKiWwa+bKazEe+ZGyqWUNK8FuOSktJgps6+Y0MkXuLjaXGrMlN/6k2Kl8VP6DToqgGRLC/dudUTFfxTKbpd7ZfRMjz+ZNuNGjTgyONPtQqgeheVxdZyV0hKDVBUpKjqpa5yVD4qVnV8nLlVnHoQYXZU3cMYtwIJC6oVAO49EbLWPI/ZQppgr8W5BoCVniGBVVuctqAHCIgZI4Ulj5UoZLLvvUq7GtbgVqmVIWKuS6NMPdQq2oYKFaSbHTygsp5PmCho7BOwdFZuWzPYzGfUrwy2zuFSs1py2gigz7vQq/VN51SC9Xe6dXTWrCrsYQcHCncNVtuSslEhlxqWZKzE6kao3M2xYnQu8SUTpxz0vbHstMaOa8NedqeaKhnvCdYWV8NwCC4pyEW1HOl1fhDP8I+ijTDFXEmiHQiVtiwn/TJGAPycGC9HdxG5mnItmXOPtjDMIuWGYiyoNn6BaXGHBpaZkQqADKk/3p6zKCDTjJn1OI/dq7XNIZefSwi2pY4VEnMJj46o800d/tTPNXEng0gE/C8Rji1yVSKGyUEVQ5QZodveDnXRzZQR+V0CVlaUTfYpKC6mHsCsErQJlhLMcRmDc7hxN/ZggCXsR3kve0qkXlxX/mlt6Bp284IgGM+54mhFHYhv3xLS0nXxd3L3zObZVsSAH+yUz/W1jtrmiGO1HFm6HDM7Ov9soM0YLi7ah3tSpvBSy+LSTDBxOQl9dcQTkjxlC1AoaSqQVk3NMQoBM4hdYkWZcSogscTP1pxqolG0pLJVi6pV2JJceqRotK3rWe+Xp+GU3zec0wCCS+hwZFjqwRNFCibihpaQbB9tHU3jScXSaGiKbgN/FfFNQLbeFCztjsFBl4lsQLHxx7Fen6SGyifveRYZQnhbI1y0WLZQ0vbim0ryY54rjNzsvGHHqvuRC1z1w7jULxgrRwUIsd5nLefax0ZhhrsSA6rww9soVrGcAZIXu62QcrCycY/CfG2/murGqSpRKXN59v1UkWiim8Gi/vledK7/i7c4sI254Y0KqXpxvOqW+KKeg5CCKR446cY6hf9qd6XMa3FneqxNPTiM6KAIr8eND3SC3MVjhzVnG8u50hrkyCtfDfntg4iqnZ869uBDUUCk8mGssVa2qMZ0DH36bx1xROIMSVigcMZ50ok+uaaHKrd+swU8JHmxz7m4hR7+94HNKomdahkqdqukUhxzToo1aUmJy+2ZhXHn+kNbbORbmGP0Am2LJLwFnJc27sKhajQh7WEmwh1cZLiUPTHDsaWOBjyLflBA1wAsVz7Kt10szl5YzJglJ9i9IAWghpA4hYew/+or9UzqOaqCm+7e82vd8D8DowOcMfVnl3vYVe+24jyIueO7mvak0aBVI4cF1E/oyvdZgsS+UZcmvsQUk+uTbYsGGZ9CsSQ7Xqcx26/+XbyHgrLSgwanF895CDYs0HMwuh35vrdfKjsWVuBUIadzaqmdAnqcQFvRgAaX8CZ3zBeT66u3xaeP9HA6W+JvkrS8jbO0pbYC8hxIhWGjjCsShj+S8g/1wjJkac/koAWi3+TWuuj8Z7GK8XiJfuHNwTRZSVPbwwFyjvTrWudmnczgp8a542z1sWQ9dK52JgolcQD089T1V4SSt2kVaPvw6qJqaw8cyhHthQi2ILcSgEUXuRAYGdA6tVSAwMTOFZwI/aVGRtMwMNY8DGpxieXyc8ZA7UgDVEOw38Kqwm0VGuBOTkl70MQ2U/MkwNCl1e5jD1VlH9iq6Gk5AG9IFcDxgZXZawgSa++CxgG2iWYkHkR+osbQhLwOD4wvmlcclHwvqFQKGtK2qJnTn4LyxQql7YkLPIdjMQhvSBS4/2onXoPn9ceprYdMFeT62YZ64uaJEAepVsLOxVH/hos11fmkAL435XbcD1EOV9m1MqbFZNvxrsGohswmChQua+kefj98cf1zARwmgKpSovzV/iT7AwLZKTOdChP1/4WC+OlrAQzn4Vkr6odBNK9k2yZ1egRbGUuvJXSyrkCxHV2FyjwidNzD1IU+sSLQdAxv5cgMreDJxeOCXNAOoB4aqLCd/GS3nDC1922CdrCwH/TUduSHl4Jlj5zkTFUpuTOhixpfgMIREH/Rsm7Ny4pcAStx/uPLsQ3JjlvEZiqmaGKo0/8lbE0L/FhzuFhesnrEYU1J/grZy0uy/9fM1g8Dnjo3RuVwfaUZFTSp+S6VNANpWWv2569/v3uiEFZZpP5C4h4mqvcuZXpH4nYETwX6x6eb3R8fBNHZu5S5fm0KHcCEwnhdsZynI7nYgLPUivOgsdytz01OBCDm9Ha/8Q1Yoe46t8m9t4U0tgV0etph6xRjshczsIPA9iTB7cziBwC+mPNlG3CQxK1gYgRJiMf9fNqAq7QubPGQM9OlYSsvnbgqRG2yenrWoxCnJalnOFSs4GB89QNZLD/HdAXkh5kXefE6E6DC734uEyF5YuBBRz89htkZs5Hc8J36dS4akOB6+MjKX7cFwVP72beiwLOHs327j7KGZ7tUXAAiM3+88lLLDQ6fv5zzXaVkdQHLeeeSl8sJX+s5cTpwY8Su6M/7W4VdvsEGhQdP0XppozxT31BqOWcqD5r+8IQ3JQdPJEDQdqdqgI3ZHzHK6Gi8eFQnQ1P855QwSV9Ro1Z3gZeZFBcPIb/yyAToiWFqI6NjxwX0LS8wcA39BDGasukVdkP/bsF3tGC/q00/F71tbX0ZaZX/d2hor0TzcSuIrMOnePX+5uen1ejdbe7ot9NcvW+P4WsQ5BCNu3TP2tJUcfJmNt8Gr3yf2wE/fIP28+Qcz9YEouMH2Lb2n8e3y0+S7nfMPqhKTBefDd/jJY2U2nmJZdzgPYoTfIO2vuW9w70LKSjdgnF1DUeefjjoBmkfgiYEzdwVsvkBJ1/zr78TLKNJZCbnXb8VAwWjuC5Wk47YuAyEg562qP+8xszw8Ndvn+S6g5DA0f+gw1QwQj6SzIrzRyyC/2Dkcfpy8osTMSvLUYgHNiUvH6fQjEcZB1ikzSIw3DgBZOdQXkAoTt0MCSowNWCne2gQDdh+hpOxaDBoDTJWVkQofnEHhYbwlknqn5irnMI1lJd4CFI4WAn0o2aOblPnprJDhGQRkxRi++uIgxDeh609RVgaMFI8VQi5NqFE5CIcFPHPJSmIGAQ4iUXMTM2ioV4rICbzLXM4D4ndZqKu9prDCgBVK9RwZzCB1ATmXq84wsDGibQsHCi3jYHGh6kGo9hnMq21BryArrRq/P9N3JEVnhcCPzLDI6wynkHIQpLES8dreADjX5Moc6hnU75pRJbFnLjor7s9CvdvGvRVhfQYrjjAcJ0Kw+0Nlrwi73uq32nu9iEWlZK5d0VlpO+JvmBl0aGNM07ZGGOOPmBXhRPf3kWPzf+5GwqVFZ+WBOfrNylLBqKSbafug2sEAvmaFO2EoZYfzH3x0P8VOuYKz4ncNp653LAG0L6ZTWTG8sWulXjE77fbB3WXAzGvs2roaaxA2LQ33AWFoQ3M3uugaBGg9mro4Wk+hgrOyxbgTaSUa4bu3FtoHISuwvAeqkxhdCVZcj7PLM429QOB7DheXFUK+jdJQbFbakRIPhZ7J8JVK/4KVOuNB4uNis1JyWMJXthepF1EsOoMovhYwSnTJLjArlLpyziQqeKsBZ3v/QlbAs30t1Ku8i70G4QOcOcpEiff830z9tsKyOcIKneF10vq1onlQ+ja2CAu4X6akYo6+m22PiagJfJWZ+b/qEESx0hoegY1QghWoLOTe2BpUQEoAvieckRJ4eE7sVFM2LbsWI4AmePWQ89rw0NnQk6Cipv3QCg4HU6igMwh/1Po9C0ZfeNJ7Yo/w3/LTINQj8QgeyCgZ5bkHHdL8g0UDr5PbfYpDSPLelaenbCumvyO+VirnoxHzs0rlBibHea+SAATQ2jfJIz2IePh/Vm5gcqnr93pwnt5zP/cqz6SAjuzBBjcxcjpxZPDJrBuNpxbH1+cy43g2lJJEnTDJwkRKz+RZSVInHz/9toXCZLrOxMFxAaKxeypxfMqFG2ywwQYbbLDBBuuK/wOU7jKC5IqQ1wAAAABJRU5ErkJggg=="
			class="center" height="200px" width="100px"> <input
			type="submit" value="Go Back" class="submit"
			style="margin-left: 350px; margin-top: 150px">
	</form>
</body>
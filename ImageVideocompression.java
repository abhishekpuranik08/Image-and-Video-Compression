public class Compression {
    public static BLogger logger;

    public static byte[] compressor(byte[] data, boolean isVideo) throws VideoException, ImageException {
        try {
            int a = data.length;
            IVCompressor compress = new IVCompressor();
            byte[] videoData = data;
            if (isVideo) {
                VideoFormats fileFormat = VideoFormats.valueOf("MP4"); // Video format
                ResizeResolution resolution = ResizeResolution.valueOf("R360P"); // Desired resolution
                byte[] compressedVideo = compress.reduceVideoSize(videoData, fileFormat, resolution);
                int b = compressedVideo.length;
                return compressedVideo;
            } else {
                ImageFormats videoFormats = ImageFormats.valueOf("JPG");
                ResizeResolution resolution = ResizeResolution.valueOf("R240P");
                byte[] compressedImage = compress.resizeImage(videoData, videoFormats, resolution);
                int b = compressedImage.length;
                return compressedImage;
            }

        } catch (Exception e) {
            logger.error("Error in Compressing  video/image" + e.getMessage());
            return new byte[0];
        }

    }

package data.messages.game.interactive.meeting
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class TeleportBuddiesAnswerMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6294;
       
      private var _isInitialized:Boolean = false;
      
      public var accept:Boolean = false;
      
      public function TeleportBuddiesAnswerMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6294;
      }
      
      public function initTeleportBuddiesAnswerMessage(param1:Boolean = false) : TeleportBuddiesAnswerMessage
      {
         this.accept = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.accept = false;
         this._isInitialized = false;
      }
      
      override public function pack(param1:ICustomDataOutput) : void
      {
         var _loc2_:ByteArray = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
      }
      
      override public function unpack(param1:ICustomDataInput, param2:uint) : void
      {
         this.deserialize(param1);
      }
      
      override public function unpackAsync(param1:ICustomDataInput, param2:uint) : FuncTree
      {
         var _loc3_:FuncTree = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
      }
      
      public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_TeleportBuddiesAnswerMessage(param1);
      }
      
      public function serializeAs_TeleportBuddiesAnswerMessage(param1:ICustomDataOutput) : void
      {
         param1.writeBoolean(this.accept);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_TeleportBuddiesAnswerMessage(param1);
      }
      
      public function deserializeAs_TeleportBuddiesAnswerMessage(param1:ICustomDataInput) : void
      {
         this._acceptFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_TeleportBuddiesAnswerMessage(param1);
      }
      
      public function deserializeAsyncAs_TeleportBuddiesAnswerMessage(param1:FuncTree) : void
      {
         param1.addChild(this._acceptFunc);
      }
      
      private function _acceptFunc(param1:ICustomDataInput) : void
      {
         this.accept = param1.readBoolean();
      }
   }
}

package data.messages.game.basic
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class NumericWhoIsRequestMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6298;
       
      private var _isInitialized:Boolean = false;
      
      public var playerId:Number = 0;
      
      public function NumericWhoIsRequestMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6298;
      }
      
      public function initNumericWhoIsRequestMessage(param1:Number = 0) : NumericWhoIsRequestMessage
      {
         this.playerId = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.playerId = 0;
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
         this.serializeAs_NumericWhoIsRequestMessage(param1);
      }
      
      public function serializeAs_NumericWhoIsRequestMessage(param1:ICustomDataOutput) : void
      {
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_NumericWhoIsRequestMessage(param1);
      }
      
      public function deserializeAs_NumericWhoIsRequestMessage(param1:ICustomDataInput) : void
      {
         this._playerIdFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_NumericWhoIsRequestMessage(param1);
      }
      
      public function deserializeAsyncAs_NumericWhoIsRequestMessage(param1:FuncTree) : void
      {
         param1.addChild(this._playerIdFunc);
      }
      
      private function _playerIdFunc(param1:ICustomDataInput) : void
      {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.playerId + ") on element of NumericWhoIsRequestMessage.playerId.");
         }
      }
   }
}

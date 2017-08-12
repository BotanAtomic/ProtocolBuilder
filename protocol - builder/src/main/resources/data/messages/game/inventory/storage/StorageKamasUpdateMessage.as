package data.messages.game.inventory.storage
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class StorageKamasUpdateMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5645;
       
      private var _isInitialized:Boolean = false;
      
      public var kamasTotal:Number = 0;
      
      public function StorageKamasUpdateMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5645;
      }
      
      public function initStorageKamasUpdateMessage(param1:Number = 0) : StorageKamasUpdateMessage
      {
         this.kamasTotal = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.kamasTotal = 0;
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
         this.serializeAs_StorageKamasUpdateMessage(param1);
      }
      
      public function serializeAs_StorageKamasUpdateMessage(param1:ICustomDataOutput) : void
      {
         if(this.kamasTotal < 0 || this.kamasTotal > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.kamasTotal + ") on element kamasTotal.");
         }
         param1.writeVarLong(this.kamasTotal);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_StorageKamasUpdateMessage(param1);
      }
      
      public function deserializeAs_StorageKamasUpdateMessage(param1:ICustomDataInput) : void
      {
         this._kamasTotalFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_StorageKamasUpdateMessage(param1);
      }
      
      public function deserializeAsyncAs_StorageKamasUpdateMessage(param1:FuncTree) : void
      {
         param1.addChild(this._kamasTotalFunc);
      }
      
      private function _kamasTotalFunc(param1:ICustomDataInput) : void
      {
         this.kamasTotal = param1.readVarUhLong();
         if(this.kamasTotal < 0 || this.kamasTotal > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.kamasTotal + ") on element of StorageKamasUpdateMessage.kamasTotal.");
         }
      }
   }
}

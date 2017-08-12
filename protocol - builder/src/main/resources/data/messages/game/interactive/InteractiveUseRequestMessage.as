package data.messages.game.interactive
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class InteractiveUseRequestMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5001;
       
      private var _isInitialized:Boolean = false;
      
      public var elemId:uint = 0;
      
      public var skillInstanceUid:uint = 0;
      
      public function InteractiveUseRequestMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5001;
      }
      
      public function initInteractiveUseRequestMessage(param1:uint = 0, param2:uint = 0) : InteractiveUseRequestMessage
      {
         this.elemId = param1;
         this.skillInstanceUid = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.elemId = 0;
         this.skillInstanceUid = 0;
         this._isInitialized = false;
      }
      
      override public function pack(param1:ICustomDataOutput) : void
      {
         var _loc2_:ByteArray = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         if(HASH_FUNCTION != null)
         {
            HASH_FUNCTION(_loc2_);
         }
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
         this.serializeAs_InteractiveUseRequestMessage(param1);
      }
      
      public function serializeAs_InteractiveUseRequestMessage(param1:ICustomDataOutput) : void
      {
         if(this.elemId < 0)
         {
            throw new Error("Forbidden value (" + this.elemId + ") on element elemId.");
         }
         param1.writeVarInt(this.elemId);
         if(this.skillInstanceUid < 0)
         {
            throw new Error("Forbidden value (" + this.skillInstanceUid + ") on element skillInstanceUid.");
         }
         param1.writeVarInt(this.skillInstanceUid);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_InteractiveUseRequestMessage(param1);
      }
      
      public function deserializeAs_InteractiveUseRequestMessage(param1:ICustomDataInput) : void
      {
         this._elemIdFunc(param1);
         this._skillInstanceUidFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_InteractiveUseRequestMessage(param1);
      }
      
      public function deserializeAsyncAs_InteractiveUseRequestMessage(param1:FuncTree) : void
      {
         param1.addChild(this._elemIdFunc);
         param1.addChild(this._skillInstanceUidFunc);
      }
      
      private function _elemIdFunc(param1:ICustomDataInput) : void
      {
         this.elemId = param1.readVarUhInt();
         if(this.elemId < 0)
         {
            throw new Error("Forbidden value (" + this.elemId + ") on element of InteractiveUseRequestMessage.elemId.");
         }
      }
      
      private function _skillInstanceUidFunc(param1:ICustomDataInput) : void
      {
         this.skillInstanceUid = param1.readVarUhInt();
         if(this.skillInstanceUid < 0)
         {
            throw new Error("Forbidden value (" + this.skillInstanceUid + ") on element of InteractiveUseRequestMessage.skillInstanceUid.");
         }
      }
   }
}

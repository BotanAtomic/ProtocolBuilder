package data.messages.game.inventory
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class AbstractPresetSaveResultMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6734;
       
      private var _isInitialized:Boolean = false;
      
      public var presetId:uint = 0;
      
      public var code:uint = 2;
      
      public function AbstractPresetSaveResultMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6734;
      }
      
      public function initAbstractPresetSaveResultMessage(param1:uint = 0, param2:uint = 2) : AbstractPresetSaveResultMessage
      {
         this.presetId = param1;
         this.code = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.presetId = 0;
         this.code = 2;
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
         this.serializeAs_AbstractPresetSaveResultMessage(param1);
      }
      
      public function serializeAs_AbstractPresetSaveResultMessage(param1:ICustomDataOutput) : void
      {
         if(this.presetId < 0)
         {
            throw new Error("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
         param1.writeByte(this.code);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_AbstractPresetSaveResultMessage(param1);
      }
      
      public function deserializeAs_AbstractPresetSaveResultMessage(param1:ICustomDataInput) : void
      {
         this._presetIdFunc(param1);
         this._codeFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_AbstractPresetSaveResultMessage(param1);
      }
      
      public function deserializeAsyncAs_AbstractPresetSaveResultMessage(param1:FuncTree) : void
      {
         param1.addChild(this._presetIdFunc);
         param1.addChild(this._codeFunc);
      }
      
      private function _presetIdFunc(param1:ICustomDataInput) : void
      {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Error("Forbidden value (" + this.presetId + ") on element of AbstractPresetSaveResultMessage.presetId.");
         }
      }
      
      private function _codeFunc(param1:ICustomDataInput) : void
      {
         this.code = param1.readByte();
         if(this.code < 0)
         {
            throw new Error("Forbidden value (" + this.code + ") on element of AbstractPresetSaveResultMessage.code.");
         }
      }
   }
}

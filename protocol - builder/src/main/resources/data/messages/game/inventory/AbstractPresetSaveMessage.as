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
   public class AbstractPresetSaveMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6736;
       
      private var _isInitialized:Boolean = false;
      
      public var presetId:uint = 0;
      
      public var symbolId:uint = 0;
      
      public function AbstractPresetSaveMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6736;
      }
      
      public function initAbstractPresetSaveMessage(param1:uint = 0, param2:uint = 0) : AbstractPresetSaveMessage
      {
         this.presetId = param1;
         this.symbolId = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.presetId = 0;
         this.symbolId = 0;
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
         this.serializeAs_AbstractPresetSaveMessage(param1);
      }
      
      public function serializeAs_AbstractPresetSaveMessage(param1:ICustomDataOutput) : void
      {
         if(this.presetId < 0)
         {
            throw new Error("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
         if(this.symbolId < 0)
         {
            throw new Error("Forbidden value (" + this.symbolId + ") on element symbolId.");
         }
         param1.writeByte(this.symbolId);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_AbstractPresetSaveMessage(param1);
      }
      
      public function deserializeAs_AbstractPresetSaveMessage(param1:ICustomDataInput) : void
      {
         this._presetIdFunc(param1);
         this._symbolIdFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_AbstractPresetSaveMessage(param1);
      }
      
      public function deserializeAsyncAs_AbstractPresetSaveMessage(param1:FuncTree) : void
      {
         param1.addChild(this._presetIdFunc);
         param1.addChild(this._symbolIdFunc);
      }
      
      private function _presetIdFunc(param1:ICustomDataInput) : void
      {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Error("Forbidden value (" + this.presetId + ") on element of AbstractPresetSaveMessage.presetId.");
         }
      }
      
      private function _symbolIdFunc(param1:ICustomDataInput) : void
      {
         this.symbolId = param1.readByte();
         if(this.symbolId < 0)
         {
            throw new Error("Forbidden value (" + this.symbolId + ") on element of AbstractPresetSaveMessage.symbolId.");
         }
      }
   }
}

package com.ankamagames.dofus.network.messages.game.context
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class ShowCellRequestMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5611;
       
      private var _isInitialized:Boolean = false;
      
      public var cellId:uint = 0;
      
      public function ShowCellRequestMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5611;
      }
      
      public function initShowCellRequestMessage(param1:uint = 0) : ShowCellRequestMessage
      {
         this.cellId = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.cellId = 0;
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
         this.serializeAs_ShowCellRequestMessage(param1);
      }
      
      public function serializeAs_ShowCellRequestMessage(param1:ICustomDataOutput) : void
      {
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Error("Forbidden value (" + this.cellId + ") on element cellId.");
         }
         param1.writeVarShort(this.cellId);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_ShowCellRequestMessage(param1);
      }
      
      public function deserializeAs_ShowCellRequestMessage(param1:ICustomDataInput) : void
      {
         this._cellIdFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_ShowCellRequestMessage(param1);
      }
      
      public function deserializeAsyncAs_ShowCellRequestMessage(param1:FuncTree) : void
      {
         param1.addChild(this._cellIdFunc);
      }
      
      private function _cellIdFunc(param1:ICustomDataInput) : void
      {
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Error("Forbidden value (" + this.cellId + ") on element of ShowCellRequestMessage.cellId.");
         }
      }
   }
}

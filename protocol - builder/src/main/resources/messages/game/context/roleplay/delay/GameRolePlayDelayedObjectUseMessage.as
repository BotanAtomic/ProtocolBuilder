package com.ankamagames.dofus.network.messages.game.context.roleplay.delay
{
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class GameRolePlayDelayedObjectUseMessage extends GameRolePlayDelayedActionMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6425;
       
      private var _isInitialized:Boolean = false;
      
      public var objectGID:uint = 0;
      
      public function GameRolePlayDelayedObjectUseMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6425;
      }
      
      public function initGameRolePlayDelayedObjectUseMessage(param1:Number = 0, param2:uint = 0, param3:Number = 0, param4:uint = 0) : GameRolePlayDelayedObjectUseMessage
      {
         super.initGameRolePlayDelayedActionMessage(param1,param2,param3);
         this.objectGID = param4;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.objectGID = 0;
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
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_GameRolePlayDelayedObjectUseMessage(param1);
      }
      
      public function serializeAs_GameRolePlayDelayedObjectUseMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_GameRolePlayDelayedActionMessage(param1);
         if(this.objectGID < 0)
         {
            throw new Error("Forbidden value (" + this.objectGID + ") on element objectGID.");
         }
         param1.writeVarShort(this.objectGID);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_GameRolePlayDelayedObjectUseMessage(param1);
      }
      
      public function deserializeAs_GameRolePlayDelayedObjectUseMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._objectGIDFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_GameRolePlayDelayedObjectUseMessage(param1);
      }
      
      public function deserializeAsyncAs_GameRolePlayDelayedObjectUseMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._objectGIDFunc);
      }
      
      private function _objectGIDFunc(param1:ICustomDataInput) : void
      {
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
         {
            throw new Error("Forbidden value (" + this.objectGID + ") on element of GameRolePlayDelayedObjectUseMessage.objectGID.");
         }
      }
   }
}

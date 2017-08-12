package data.messages.game.actions.fight
{
   import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class GameActionFightCarryCharacterMessage extends AbstractGameActionMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5830;
       
      private var _isInitialized:Boolean = false;
      
      public var targetId:Number = 0;
      
      public var cellId:int = 0;
      
      public function GameActionFightCarryCharacterMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5830;
      }
      
      public function initGameActionFightCarryCharacterMessage(param1:uint = 0, param2:Number = 0, param3:Number = 0, param4:int = 0) : GameActionFightCarryCharacterMessage
      {
         super.initAbstractGameActionMessage(param1,param2);
         this.targetId = param3;
         this.cellId = param4;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.targetId = 0;
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
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_GameActionFightCarryCharacterMessage(param1);
      }
      
      public function serializeAs_GameActionFightCarryCharacterMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_AbstractGameActionMessage(param1);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         if(this.cellId < -1 || this.cellId > 559)
         {
            throw new Error("Forbidden value (" + this.cellId + ") on element cellId.");
         }
         param1.writeShort(this.cellId);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_GameActionFightCarryCharacterMessage(param1);
      }
      
      public function deserializeAs_GameActionFightCarryCharacterMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._targetIdFunc(param1);
         this._cellIdFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_GameActionFightCarryCharacterMessage(param1);
      }
      
      public function deserializeAsyncAs_GameActionFightCarryCharacterMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._targetIdFunc);
         param1.addChild(this._cellIdFunc);
      }
      
      private function _targetIdFunc(param1:ICustomDataInput) : void
      {
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.targetId + ") on element of GameActionFightCarryCharacterMessage.targetId.");
         }
      }
      
      private function _cellIdFunc(param1:ICustomDataInput) : void
      {
         this.cellId = param1.readShort();
         if(this.cellId < -1 || this.cellId > 559)
         {
            throw new Error("Forbidden value (" + this.cellId + ") on element of GameActionFightCarryCharacterMessage.cellId.");
         }
      }
   }
}

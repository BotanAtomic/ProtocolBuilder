package com.ankamagames.dofus.network.messages.game.context.roleplay.spell
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class SpellModifySuccessMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6654;
       
      private var _isInitialized:Boolean = false;
      
      public var spellId:int = 0;
      
      public var spellLevel:int = 0;
      
      public function SpellModifySuccessMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6654;
      }
      
      public function initSpellModifySuccessMessage(param1:int = 0, param2:int = 0) : SpellModifySuccessMessage
      {
         this.spellId = param1;
         this.spellLevel = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.spellId = 0;
         this.spellLevel = 0;
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
         this.serializeAs_SpellModifySuccessMessage(param1);
      }
      
      public function serializeAs_SpellModifySuccessMessage(param1:ICustomDataOutput) : void
      {
         param1.writeInt(this.spellId);
         if(this.spellLevel < 1 || this.spellLevel > 200)
         {
            throw new Error("Forbidden value (" + this.spellLevel + ") on element spellLevel.");
         }
         param1.writeShort(this.spellLevel);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_SpellModifySuccessMessage(param1);
      }
      
      public function deserializeAs_SpellModifySuccessMessage(param1:ICustomDataInput) : void
      {
         this._spellIdFunc(param1);
         this._spellLevelFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_SpellModifySuccessMessage(param1);
      }
      
      public function deserializeAsyncAs_SpellModifySuccessMessage(param1:FuncTree) : void
      {
         param1.addChild(this._spellIdFunc);
         param1.addChild(this._spellLevelFunc);
      }
      
      private function _spellIdFunc(param1:ICustomDataInput) : void
      {
         this.spellId = param1.readInt();
      }
      
      private function _spellLevelFunc(param1:ICustomDataInput) : void
      {
         this.spellLevel = param1.readShort();
         if(this.spellLevel < 1 || this.spellLevel > 200)
         {
            throw new Error("Forbidden value (" + this.spellLevel + ") on element of SpellModifySuccessMessage.spellLevel.");
         }
      }
   }
}

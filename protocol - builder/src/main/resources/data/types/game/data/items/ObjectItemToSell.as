package data.types.game.data.items
{
   import com.ankamagames.jerakine.network.INetworkType;
   import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.dofus.network.ProtocolTypeManager;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   public class ObjectItemToSell extends Item implements INetworkType
   {
      
      public static const protocolId:uint = 120;
       
      public var objectGID:uint = 0;
      
      public var effects:Vector.<ObjectEffect>;
      
      public var objectUID:uint = 0;
      
      public var quantity:uint = 0;
      
      public var objectPrice:Number = 0;
      
      private var _effectstree:FuncTree;
      
      public function ObjectItemToSell()
      {
         this.effects = new Vector.<ObjectEffect>();
         super();
      }
      
      override public function getTypeId() : uint
      {
         return 120;
      }
      
      public function initObjectItemToSell(param1:uint = 0, param2:Vector.<ObjectEffect> = null, param3:uint = 0, param4:uint = 0, param5:Number = 0) : ObjectItemToSell
      {
         this.objectGID = param1;
         this.effects = param2;
         this.objectUID = param3;
         this.quantity = param4;
         this.objectPrice = param5;
         return this;
      }
      
      override public function reset() : void
      {
         this.objectGID = 0;
         this.effects = new Vector.<ObjectEffect>();
         this.objectUID = 0;
         this.quantity = 0;
         this.objectPrice = 0;
      }
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_ObjectItemToSell(param1);
      }
      
      public function serializeAs_ObjectItemToSell(param1:ICustomDataOutput) : void
      {
         super.serializeAs_Item(param1);
         if(this.objectGID < 0)
         {
            throw new Error("Forbidden value (" + this.objectGID + ") on element objectGID.");
         }
         param1.writeVarShort(this.objectGID);
         param1.writeShort(this.effects.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.effects.length)
         {
            param1.writeShort((this.effects[_loc2_] as ObjectEffect).getTypeId());
            (this.effects[_loc2_] as ObjectEffect).serialize(param1);
            _loc2_++;
         }
         if(this.objectUID < 0)
         {
            throw new Error("Forbidden value (" + this.objectUID + ") on element objectUID.");
         }
         param1.writeVarInt(this.objectUID);
         if(this.quantity < 0)
         {
            throw new Error("Forbidden value (" + this.quantity + ") on element quantity.");
         }
         param1.writeVarInt(this.quantity);
         if(this.objectPrice < 0 || this.objectPrice > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.objectPrice + ") on element objectPrice.");
         }
         param1.writeVarLong(this.objectPrice);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_ObjectItemToSell(param1);
      }
      
      public function deserializeAs_ObjectItemToSell(param1:ICustomDataInput) : void
      {
         var _loc4_:uint = 0;
         var _loc5_:ObjectEffect = null;
         super.deserialize(param1);
         this._objectGIDFunc(param1);
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc4_);
            _loc5_.deserialize(param1);
            this.effects.push(_loc5_);
            _loc3_++;
         }
         this._objectUIDFunc(param1);
         this._quantityFunc(param1);
         this._objectPriceFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_ObjectItemToSell(param1);
      }
      
      public function deserializeAsyncAs_ObjectItemToSell(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._objectGIDFunc);
         this._effectstree = param1.addChild(this._effectstreeFunc);
         param1.addChild(this._objectUIDFunc);
         param1.addChild(this._quantityFunc);
         param1.addChild(this._objectPriceFunc);
      }
      
      private function _objectGIDFunc(param1:ICustomDataInput) : void
      {
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
         {
            throw new Error("Forbidden value (" + this.objectGID + ") on element of ObjectItemToSell.objectGID.");
         }
      }
      
      private function _effectstreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._effectstree.addChild(this._effectsFunc);
            _loc3_++;
         }
      }
      
      private function _effectsFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:ObjectEffect = ProtocolTypeManager.getInstance(ObjectEffect,_loc2_);
         _loc3_.deserialize(param1);
         this.effects.push(_loc3_);
      }
      
      private function _objectUIDFunc(param1:ICustomDataInput) : void
      {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
         {
            throw new Error("Forbidden value (" + this.objectUID + ") on element of ObjectItemToSell.objectUID.");
         }
      }
      
      private function _quantityFunc(param1:ICustomDataInput) : void
      {
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
         {
            throw new Error("Forbidden value (" + this.quantity + ") on element of ObjectItemToSell.quantity.");
         }
      }
      
      private function _objectPriceFunc(param1:ICustomDataInput) : void
      {
         this.objectPrice = param1.readVarUhLong();
         if(this.objectPrice < 0 || this.objectPrice > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.objectPrice + ") on element of ObjectItemToSell.objectPrice.");
         }
      }
   }
}

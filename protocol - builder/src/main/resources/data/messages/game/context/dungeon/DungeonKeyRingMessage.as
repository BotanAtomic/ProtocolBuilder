package data.messages.game.context.dungeon
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class DungeonKeyRingMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6299;
       
      private var _isInitialized:Boolean = false;
      
      public var availables:Vector.<uint>;
      
      public var unavailables:Vector.<uint>;
      
      private var _availablestree:FuncTree;
      
      private var _unavailablestree:FuncTree;
      
      public function DungeonKeyRingMessage()
      {
         this.availables = new Vector.<uint>();
         this.unavailables = new Vector.<uint>();
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6299;
      }
      
      public function initDungeonKeyRingMessage(param1:Vector.<uint> = null, param2:Vector.<uint> = null) : DungeonKeyRingMessage
      {
         this.availables = param1;
         this.unavailables = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.availables = new Vector.<uint>();
         this.unavailables = new Vector.<uint>();
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
         this.serializeAs_DungeonKeyRingMessage(param1);
      }
      
      public function serializeAs_DungeonKeyRingMessage(param1:ICustomDataOutput) : void
      {
         param1.writeShort(this.availables.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.availables.length)
         {
            if(this.availables[_loc2_] < 0)
            {
               throw new Error("Forbidden value (" + this.availables[_loc2_] + ") on element 1 (starting at 1) of availables.");
            }
            param1.writeVarShort(this.availables[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.unavailables.length);
         var _loc3_:uint = 0;
         while(_loc3_ < this.unavailables.length)
         {
            if(this.unavailables[_loc3_] < 0)
            {
               throw new Error("Forbidden value (" + this.unavailables[_loc3_] + ") on element 2 (starting at 1) of unavailables.");
            }
            param1.writeVarShort(this.unavailables[_loc3_]);
            _loc3_++;
         }
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_DungeonKeyRingMessage(param1);
      }
      
      public function deserializeAs_DungeonKeyRingMessage(param1:ICustomDataInput) : void
      {
         var _loc6_:uint = 0;
         var _loc7_:uint = 0;
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0)
            {
               throw new Error("Forbidden value (" + _loc6_ + ") on elements of availables.");
            }
            this.availables.push(_loc6_);
            _loc3_++;
         }
         var _loc4_:uint = param1.readUnsignedShort();
         var _loc5_:uint = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhShort();
            if(_loc7_ < 0)
            {
               throw new Error("Forbidden value (" + _loc7_ + ") on elements of unavailables.");
            }
            this.unavailables.push(_loc7_);
            _loc5_++;
         }
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_DungeonKeyRingMessage(param1);
      }
      
      public function deserializeAsyncAs_DungeonKeyRingMessage(param1:FuncTree) : void
      {
         this._availablestree = param1.addChild(this._availablestreeFunc);
         this._unavailablestree = param1.addChild(this._unavailablestreeFunc);
      }
      
      private function _availablestreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._availablestree.addChild(this._availablesFunc);
            _loc3_++;
         }
      }
      
      private function _availablesFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Error("Forbidden value (" + _loc2_ + ") on elements of availables.");
         }
         this.availables.push(_loc2_);
      }
      
      private function _unavailablestreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._unavailablestree.addChild(this._unavailablesFunc);
            _loc3_++;
         }
      }
      
      private function _unavailablesFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Error("Forbidden value (" + _loc2_ + ") on elements of unavailables.");
         }
         this.unavailables.push(_loc2_);
      }
   }
}

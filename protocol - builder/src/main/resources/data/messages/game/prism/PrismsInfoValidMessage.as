package data.messages.game.prism
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.dofus.network.types.game.prism.PrismFightersInformation;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class PrismsInfoValidMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6451;
       
      private var _isInitialized:Boolean = false;
      
      public var fights:Vector.<PrismFightersInformation>;
      
      private var _fightstree:FuncTree;
      
      public function PrismsInfoValidMessage()
      {
         this.fights = new Vector.<PrismFightersInformation>();
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6451;
      }
      
      public function initPrismsInfoValidMessage(param1:Vector.<PrismFightersInformation> = null) : PrismsInfoValidMessage
      {
         this.fights = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.fights = new Vector.<PrismFightersInformation>();
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
         this.serializeAs_PrismsInfoValidMessage(param1);
      }
      
      public function serializeAs_PrismsInfoValidMessage(param1:ICustomDataOutput) : void
      {
         param1.writeShort(this.fights.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.fights.length)
         {
            (this.fights[_loc2_] as PrismFightersInformation).serializeAs_PrismFightersInformation(param1);
            _loc2_++;
         }
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_PrismsInfoValidMessage(param1);
      }
      
      public function deserializeAs_PrismsInfoValidMessage(param1:ICustomDataInput) : void
      {
         var _loc4_:PrismFightersInformation = null;
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new PrismFightersInformation();
            _loc4_.deserialize(param1);
            this.fights.push(_loc4_);
            _loc3_++;
         }
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_PrismsInfoValidMessage(param1);
      }
      
      public function deserializeAsyncAs_PrismsInfoValidMessage(param1:FuncTree) : void
      {
         this._fightstree = param1.addChild(this._fightstreeFunc);
      }
      
      private function _fightstreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._fightstree.addChild(this._fightsFunc);
            _loc3_++;
         }
      }
      
      private function _fightsFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:PrismFightersInformation = new PrismFightersInformation();
         _loc2_.deserialize(param1);
         this.fights.push(_loc2_);
      }
   }
}
